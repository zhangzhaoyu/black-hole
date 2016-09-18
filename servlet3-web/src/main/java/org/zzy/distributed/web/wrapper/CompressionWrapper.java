package org.zzy.distributed.web.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class CompressionWrapper extends HttpServletResponseWrapper {

    private GZipServletOutputStream gZipServletOutputStream;
    private PrintWriter writer;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    public CompressionWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (writer != null) {
            throw new IllegalStateException();
        }
        if (this.gZipServletOutputStream == null) {
            gZipServletOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
        }
        return gZipServletOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (gZipServletOutputStream != null) {
            throw new IllegalStateException();
        }
        if (this.writer == null) {
            this.gZipServletOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    this.gZipServletOutputStream,
                    getResponse().getCharacterEncoding()
            );
            this.writer = new PrintWriter(outputStreamWriter);
        }
        return this.writer;
    }

    public GZIPOutputStream getGZIPOutputStream() {
        if (this.gZipServletOutputStream == null) {
            return null;
        }
        return this.gZipServletOutputStream.getGzipOutputStream();
    }
}
