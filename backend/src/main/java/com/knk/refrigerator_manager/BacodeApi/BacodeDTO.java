package com.knk.refrigerator_manager.BacodeApi;

import lombok.Data;

@Data
public class BacodeDTO {
    private String PRDLST_REPORT_NO;
    private String PRMS_DT;
    private String END_DT;
    private String PRDLST_NM;
    private String POG_DAYCNT;
    private String PRDLST_DCNM;
    private String BSSH_NM;
    private String INDUTY_NM;
    private String SITE_ADDR;
    private String CLSBIZ_DT;
    private String BAR_CD;

//    @Data
//    static class C005{
//        private int total_count;
//        private Raw[] raws;
//        private Result result;
//    }
//
//    @Data
//    static class Raw{ //해당 응답에만 사용하므로 static inner class로 선언하여 사용
//        public String CLSBIZ_DT;
//        public String SITE_ADDR;
//        public String PRDLST_REPORT_NO;
//        public String PRMS_DT;
//        public String PRDLST_NM;
//        public String BAR_CD;
//        public String POG_DAYCNT;
//        public String PRDLST_DCNM;
//        public String BSSH_NM;
//        public String END_DT;
//        public String INDUTY_NM;
//    }
//
//    @Data
//    static class Result{
//        public String MSG;
//        public String CODE;
//    }
}
