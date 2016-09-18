package org.zzy.distributed.web.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class GZipServletOutputStream extends ServletOutputStream {

    private GZIPOutputStream gzipOutputStream;

    public GZipServletOutputStream(ServletOutputStream servletOutputStream) throws IOException {
        this.gzipOutputStream = new GZIPOutputStream(servletOutputStream);
    }

    @Override
    public void write(byte[] b) throws IOException {
        gzipOutputStream.write(b);
    }

    public GZIPOutputStream getGzipOutputStream() {
        return gzipOutputStream;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public void write(int b) throws IOException {

    }
}
