package com.bhi.commonlib.nearByPlaces.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\u0002\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u001c\u00101\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u00104R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\'R\u0016\u0010\u0017\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001d\u00a8\u00068"}, d2 = {"Lcom/bhi/commonlib/nearByPlaces/model/NearByPlace;", "", "business_status", "", "geometry", "Lcom/bhi/commonlib/nearByPlaces/model/Geometry;", "icon", "name", "opening_hours", "Lcom/bhi/commonlib/nearByPlaces/model/OpeningHours;", "photos", "", "Lcom/bhi/commonlib/nearByPlaces/model/Photos;", "place_id", "plus_code", "Lcom/bhi/commonlib/nearByPlaces/model/PlusCode;", "price_level", "", "rating", "", "reference", "scope", "types", "user_ratings_total", "vicinity", "permanently_closed", "", "(Ljava/lang/String;Lcom/bhi/commonlib/nearByPlaces/model/Geometry;Ljava/lang/String;Ljava/lang/String;Lcom/bhi/commonlib/nearByPlaces/model/OpeningHours;Ljava/util/List;Ljava/lang/String;Lcom/bhi/commonlib/nearByPlaces/model/PlusCode;IDLjava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Z)V", "getBusiness_status", "()Ljava/lang/String;", "getGeometry", "()Lcom/bhi/commonlib/nearByPlaces/model/Geometry;", "getIcon", "getName", "getOpening_hours", "()Lcom/bhi/commonlib/nearByPlaces/model/OpeningHours;", "getPermanently_closed", "()Z", "getPhotos", "()Ljava/util/List;", "getPlace_id", "getPlus_code", "()Lcom/bhi/commonlib/nearByPlaces/model/PlusCode;", "getPrice_level", "()I", "getRating", "()D", "getReference", "getScope", "typeFromApiRequest", "getTypeFromApiRequest", "setTypeFromApiRequest", "(Ljava/lang/String;)V", "getTypes", "getUser_ratings_total", "getVicinity", "commonlib_debug"})
public final class NearByPlace {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "business_status")
    private final java.lang.String business_status = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "geometry")
    private final com.bhi.commonlib.nearByPlaces.model.Geometry geometry = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "icon")
    private final java.lang.String icon = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name")
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "opening_hours")
    private final com.bhi.commonlib.nearByPlaces.model.OpeningHours opening_hours = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "photos")
    private final java.util.List<com.bhi.commonlib.nearByPlaces.model.Photos> photos = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "place_id")
    private final java.lang.String place_id = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "plus_code")
    private final com.bhi.commonlib.nearByPlaces.model.PlusCode plus_code = null;
    @com.google.gson.annotations.SerializedName(value = "price_level")
    private final int price_level = 0;
    @com.google.gson.annotations.SerializedName(value = "rating")
    private final double rating = 0.0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reference")
    private final java.lang.String reference = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "scope")
    private final java.lang.String scope = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "types")
    private final java.util.List<java.lang.String> types = null;
    @com.google.gson.annotations.SerializedName(value = "user_ratings_total")
    private final int user_ratings_total = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "vicinity")
    private final java.lang.String vicinity = null;
    @com.google.gson.annotations.SerializedName(value = "permanently_closed")
    private final boolean permanently_closed = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String typeFromApiRequest;
    
    public NearByPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String business_status, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.nearByPlaces.model.Geometry geometry, @org.jetbrains.annotations.NotNull()
    java.lang.String icon, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.nearByPlaces.model.OpeningHours opening_hours, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bhi.commonlib.nearByPlaces.model.Photos> photos, @org.jetbrains.annotations.NotNull()
    java.lang.String place_id, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.nearByPlaces.model.PlusCode plus_code, int price_level, double rating, @org.jetbrains.annotations.NotNull()
    java.lang.String reference, @org.jetbrains.annotations.NotNull()
    java.lang.String scope, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> types, int user_ratings_total, @org.jetbrains.annotations.NotNull()
    java.lang.String vicinity, boolean permanently_closed) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBusiness_status() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.nearByPlaces.model.Geometry getGeometry() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.nearByPlaces.model.OpeningHours getOpening_hours() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bhi.commonlib.nearByPlaces.model.Photos> getPhotos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlace_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.nearByPlaces.model.PlusCode getPlus_code() {
        return null;
    }
    
    public final int getPrice_level() {
        return 0;
    }
    
    public final double getRating() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTypes() {
        return null;
    }
    
    public final int getUser_ratings_total() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVicinity() {
        return null;
    }
    
    public final boolean getPermanently_closed() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTypeFromApiRequest() {
        return null;
    }
    
    public final void setTypeFromApiRequest(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}