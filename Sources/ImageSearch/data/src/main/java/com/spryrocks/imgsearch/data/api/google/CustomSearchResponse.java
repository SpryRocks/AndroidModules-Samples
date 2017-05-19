package com.spryrocks.imgsearch.data.api.google;

import java.util.List;

class CustomSearchResponse {
    List<Item> items;

    static class Item {
        String title;
        String mime;
        Image image;
    }

    static class Image {
        String thumbnailLink;
    }
}
