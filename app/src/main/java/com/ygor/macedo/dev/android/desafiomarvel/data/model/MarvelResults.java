package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarvelResults implements Parcelable {

    @SerializedName("characters")
    private MarvelCharacters marvelCharacters;
    @SerializedName("collected_issues")
    private List<Object> collectedIssues;
    @SerializedName("collections")
    private List<Object> collections;
    @SerializedName("creators")
    private MarvelCreators marvelCreators;
    @SerializedName("dates")
    private List<MarvelDate> marvelDates;
    @SerializedName("description")
    private String description;
    @SerializedName("diamond_code")
    private String diamondCode;
    @SerializedName("digital_id")
    private Long digitalId;
    @SerializedName("ean")
    private String ean;
    @SerializedName("events")
    private MarvelEvents marvelEvents;
    @SerializedName("format")
    private String format;
    @SerializedName("id")
    private Long id;
    @SerializedName("images")
    private List<MarvelImage> marvelImages;
    @SerializedName("isbn")
    private String isbn;
    @SerializedName("issn")
    private String issn;
    @SerializedName("issue_number")
    private Long issueNumber;
    @SerializedName("modified")
    private String modified;
    @SerializedName("page_count")
    private Long pageCount;
    @SerializedName("prices")
    private List<MarvelPrice> marvelPrices;
    @SerializedName("resorce_uri")
    private String resourceURI;
    @SerializedName("series")
    private MarvelSeries marvelSeries;
    @SerializedName("stories")
    private MarvelStories marvelStories;
    @SerializedName("text_objects")
    private List<MarvelTextObject> marvelTextObjects;
    @SerializedName("thumbnail")
    private MarvelThumbnail marvelThumbnail;
    @SerializedName("title")
    private String title;
    @SerializedName("upc")
    private String upc;
    @SerializedName("urls")
    private List<MarvelUrl> marvelUrls;
    @SerializedName("variant_description")
    private String variantDescription;
    @SerializedName("variants")
    private List<Object> variants;

    protected MarvelResults(Parcel in) {
        marvelCharacters = in.readParcelable(MarvelCharacters.class.getClassLoader());
        marvelCreators = in.readParcelable(MarvelCreators.class.getClassLoader());
        marvelDates = in.createTypedArrayList(MarvelDate.CREATOR);
        description = in.readString();
        diamondCode = in.readString();
        if (in.readByte() == 0) {
            digitalId = null;
        } else {
            digitalId = in.readLong();
        }
        ean = in.readString();
        marvelEvents = in.readParcelable(MarvelEvents.class.getClassLoader());
        format = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        marvelImages = in.createTypedArrayList(MarvelImage.CREATOR);
        isbn = in.readString();
        issn = in.readString();
        if (in.readByte() == 0) {
            issueNumber = null;
        } else {
            issueNumber = in.readLong();
        }
        modified = in.readString();
        if (in.readByte() == 0) {
            pageCount = null;
        } else {
            pageCount = in.readLong();
        }
        marvelPrices = in.createTypedArrayList(MarvelPrice.CREATOR);
        resourceURI = in.readString();
        marvelSeries = in.readParcelable(MarvelSeries.class.getClassLoader());
        marvelStories = in.readParcelable(MarvelStories.class.getClassLoader());
        marvelTextObjects = in.createTypedArrayList(MarvelTextObject.CREATOR);
        marvelThumbnail = in.readParcelable(MarvelThumbnail.class.getClassLoader());
        title = in.readString();
        upc = in.readString();
        marvelUrls = in.createTypedArrayList(MarvelUrl.CREATOR);
        variantDescription = in.readString();
    }

    public static final Creator<MarvelResults> CREATOR = new Creator<MarvelResults>() {
        @Override
        public MarvelResults createFromParcel(Parcel in) {
            return new MarvelResults(in);
        }

        @Override
        public MarvelResults[] newArray(int size) {
            return new MarvelResults[size];
        }
    };

    public MarvelCharacters getMarvelCharacters() {
        return marvelCharacters;
    }

    public void setMarvelCharacters(MarvelCharacters marvelCharacters) {
        this.marvelCharacters = marvelCharacters;
    }

    public List<Object> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<Object> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<Object> getCollections() {
        return collections;
    }

    public void setCollections(List<Object> collections) {
        this.collections = collections;
    }

    public MarvelCreators getMarvelCreators() {
        return marvelCreators;
    }

    public void setMarvelCreators(MarvelCreators marvelCreators) {
        this.marvelCreators = marvelCreators;
    }

    public List<MarvelDate> getMarvelDates() {
        return marvelDates;
    }

    public void setMarvelDates(List<MarvelDate> marvelDates) {
        this.marvelDates = marvelDates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public Long getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(Long digitalId) {
        this.digitalId = digitalId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public MarvelEvents getMarvelEvents() {
        return marvelEvents;
    }

    public void setMarvelEvents(MarvelEvents marvelEvents) {
        this.marvelEvents = marvelEvents;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MarvelImage> getMarvelImages() {
        return marvelImages;
    }

    public void setMarvelImages(List<MarvelImage> marvelImages) {
        this.marvelImages = marvelImages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public Long getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Long issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public List<MarvelPrice> getMarvelPrices() {
        return marvelPrices;
    }

    public void setMarvelPrices(List<MarvelPrice> marvelPrices) {
        this.marvelPrices = marvelPrices;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public MarvelSeries getMarvelSeries() {
        return marvelSeries;
    }

    public void setMarvelSeries(MarvelSeries marvelSeries) {
        this.marvelSeries = marvelSeries;
    }

    public MarvelStories getMarvelStories() {
        return marvelStories;
    }

    public void setMarvelStories(MarvelStories marvelStories) {
        this.marvelStories = marvelStories;
    }

    public List<MarvelTextObject> getMarvelTextObjects() {
        return marvelTextObjects;
    }

    public void setMarvelTextObjects(List<MarvelTextObject> marvelTextObjects) {
        this.marvelTextObjects = marvelTextObjects;
    }

    public MarvelThumbnail getMarvelThumbnail() {
        return marvelThumbnail;
    }

    public void setMarvelThumbnail(MarvelThumbnail marvelThumbnail) {
        this.marvelThumbnail = marvelThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public List<MarvelUrl> getMarvelUrls() {
        return marvelUrls;
    }

    public void setMarvelUrls(List<MarvelUrl> marvelUrls) {
        this.marvelUrls = marvelUrls;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public List<Object> getVariants() {
        return variants;
    }

    public void setVariants(List<Object> variants) {
        this.variants = variants;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(marvelCharacters, flags);
        dest.writeParcelable(marvelCreators, flags);
        dest.writeTypedList(marvelDates);
        dest.writeString(description);
        dest.writeString(diamondCode);
        if (digitalId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(digitalId);
        }
        dest.writeString(ean);
        dest.writeParcelable(marvelEvents, flags);
        dest.writeString(format);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeTypedList(marvelImages);
        dest.writeString(isbn);
        dest.writeString(issn);
        if (issueNumber == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(issueNumber);
        }
        dest.writeString(modified);
        if (pageCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(pageCount);
        }
        dest.writeTypedList(marvelPrices);
        dest.writeString(resourceURI);
        dest.writeParcelable(marvelSeries, flags);
        dest.writeParcelable(marvelStories, flags);
        dest.writeTypedList(marvelTextObjects);
        dest.writeParcelable(marvelThumbnail, flags);
        dest.writeString(title);
        dest.writeString(upc);
        dest.writeTypedList(marvelUrls);
        dest.writeString(variantDescription);
    }
}