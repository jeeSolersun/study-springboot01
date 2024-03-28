package com.codeify.springboot01.elasticsearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author codeify
 * @since 2023/09/04 22:52
 */
@NoArgsConstructor
@Data
public class HotelDto {
    @JsonProperty("member")
    private MemberDTO member;
    @JsonProperty("score")
    private ScoreDTO score;
    @JsonProperty("money")
    private MoneyDTO money;
    @JsonProperty("base")
    private BaseDTO base;
    @JsonProperty("picture")
    private PictureDTO picture;
    @JsonProperty("position")
    private PositionDTO position;
    @JsonProperty("transport")
    private TransportDTO transport;
    @JsonProperty("comment")
    private CommentDTO comment;
    @JsonProperty("banner")
    private BannerDTO banner;
    @JsonProperty("trace")
    private TraceDTO trace;
    @JsonProperty("encourage")
    private EncourageDTO encourage;
    @JsonProperty("promotion")
    private List<?> promotion;
    @JsonProperty("isHotHotel")
    private Boolean isHotHotel;
    @JsonProperty("ctripTrace")
    private CtripTraceDTO ctripTrace;
    @JsonProperty("passToNext")
    private String passToNext;
    @JsonProperty("traceInfo")
    private String traceInfo;
    @JsonProperty("computeRoomPerson")
    private Integer computeRoomPerson;

    @NoArgsConstructor
    @Data
    public static class MemberDTO {
        @JsonProperty("list")
        private List<?> list;
    }

    @NoArgsConstructor
    @Data
    public static class ScoreDTO {
        @JsonProperty("number")
        private String number;
        @JsonProperty("desc")
        private String desc;
        @JsonProperty("subScore")
        private List<SubScoreDTO> subScore;

        @NoArgsConstructor
        @Data
        public static class SubScoreDTO {
            @JsonProperty("number")
            private String number;
            @JsonProperty("content")
            private String content;
        }
    }

    @NoArgsConstructor
    @Data
    public static class MoneyDTO {
        @JsonProperty("price")
        private String price;
        @JsonProperty("priceNote")
        private String priceNote;
        @JsonProperty("discount")
        private List<?> discount;
        @JsonProperty("priceAndTax")
        private String priceAndTax;
    }

    @NoArgsConstructor
    @Data
    public static class BaseDTO {
        @JsonProperty("starType")
        private String starType;
        @JsonProperty("star")
        private Integer star;
        @JsonProperty("hotelName")
        private String hotelName;
        @JsonProperty("hotelId")
        private Integer hotelId;
        @JsonProperty("bookUrl")
        private String bookUrl;
        @JsonProperty("book")
        private String book;
        @JsonProperty("badge")
        private String badge;
        @JsonProperty("badgeHover")
        private String badgeHover;
        @JsonProperty("isFavor")
        private Boolean isFavor;
        @JsonProperty("hotelEnName")
        private String hotelEnName;
        @JsonProperty("tags")
        private List<String> tags;
        @JsonProperty("isFullRoom")
        private Boolean isFullRoom;
        @JsonProperty("isPrimeHotel")
        private Boolean isPrimeHotel;
        @JsonProperty("encryptTags")
        private List<?> encryptTags;
        @JsonProperty("p5Tags")
        private List<?> p5Tags;
        @JsonProperty("p6Tags")
        private List<?> p6Tags;
        @JsonProperty("person")
        private Integer person;
        @JsonProperty("shaIcon")
        private String shaIcon;
        @JsonProperty("starIcon")
        private String starIcon;
        @JsonProperty("hotelStatus")
        private Integer hotelStatus;
        @JsonProperty("hotelTypeTag")
        private String hotelTypeTag;
    }

    @NoArgsConstructor
    @Data
    public static class PictureDTO {
        @JsonProperty("list")
        private List<String> list;
        @JsonProperty("defaultUrl")
        private String defaultUrl;
    }

    @NoArgsConstructor
    @Data
    public static class PositionDTO {
        @JsonProperty("cityId")
        private Integer cityId;
        @JsonProperty("area")
        private String area;
        @JsonProperty("poi")
        private String poi;
        @JsonProperty("lat")
        private String lat;
        @JsonProperty("lng")
        private String lng;
        @JsonProperty("address")
        private String address;
        @JsonProperty("cityName")
        private String cityName;
    }

    @NoArgsConstructor
    @Data
    public static class TransportDTO {
    }

    @NoArgsConstructor
    @Data
    public static class CommentDTO {
        @JsonProperty("content")
        private String content;
    }

    @NoArgsConstructor
    @Data
    public static class BannerDTO {
        @JsonProperty("type")
        private Integer type;
    }

    @NoArgsConstructor
    @Data
    public static class TraceDTO {
    }

    @NoArgsConstructor
    @Data
    public static class EncourageDTO {
    }

    @NoArgsConstructor
    @Data
    public static class CtripTraceDTO {
        @JsonProperty("listRoomId")
        private Integer listRoomId;
        @JsonProperty("listShadowId")
        private Integer listShadowId;
        @JsonProperty("exchange")
        private String exchange;
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("productInfo")
        private String productInfo;
    }
}
