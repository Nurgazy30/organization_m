package kg.nurgazy.organization.management.config;

import java.util.HashMap;
import java.util.Map;

public class MimeTypes {

    private static final Map<String, String>  MIME_TYPES = new HashMap<String, String>();

    static {
        //Text types
        MIME_TYPES.put("txt", "text/plain");
        MIME_TYPES.put("xml", "application/xml");
        MIME_TYPES.put("csv", "text/csv");
        //Image types
        MIME_TYPES.put("png", "image/png");
        MIME_TYPES.put("jpg", "image/jpeg");
        MIME_TYPES.put("jpeg", "image/jpeg");
        //Archive types
        MIME_TYPES.put("rar", "application/vnd.rar");
        MIME_TYPES.put("zip", "application/zip");

        //Document types
        MIME_TYPES.put("pdf", "application/pdf");
        MIME_TYPES.put("ppt", "application/vnd.ms-powerpoint");
        MIME_TYPES.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        MIME_TYPES.put("xls", "application/vnd.ms-excel");
        MIME_TYPES.put("doc", "application/msword");
        MIME_TYPES.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");



    }

    public static String getMimeType(String mimeType) {
        return MIME_TYPES.get(mimeType);
    }
}
