package com.ygor.macedo.dev.android.desafiomarvel.util;

import android.app.Activity;
import android.os.Build;
import android.transition.Explode;
import android.view.Window;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.annotation.RequiresApi;

public class MarvelMd5HashEncription {

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
