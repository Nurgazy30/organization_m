package kg.nurgazy.organization.management.controller.view;

import kg.nurgazy.organization.management.config.MimeTypes;
import kg.nurgazy.organization.management.entity.FileEntity;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import java.io.ByteArrayInputStream;

public class FileDownloadView {

    FileEntity fe = null;

    public StreamedContent download(FileEntity obj) {
        if (fe == null) fe = obj;

        if (fe != null && obj != null) fe = obj;

        if (obj == null) obj = fe;
        ByteArrayInputStream bais = new ByteArrayInputStream(obj.getFileObject());


        return DefaultStreamedContent.builder()
                .name(obj.getFileName())
                .contentType(MimeTypes.getMimeType(obj.getFileExtension()))
                .stream(() -> bais)
                .build();
    }
}
