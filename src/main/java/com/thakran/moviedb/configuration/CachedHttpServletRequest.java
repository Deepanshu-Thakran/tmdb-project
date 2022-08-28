package com.thakran.moviedb.configuration;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class CachedHttpServletRequest extends HttpServletRequestWrapper {

    private final byte[] cachedRequest;

    public CachedHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        InputStream inputStream = request.getInputStream();
        this.cachedRequest = StreamUtils.copyToByteArray(inputStream);

    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedBodyServletInputStream(this.cachedRequest);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        // Create a reader from cachedContent
        // and return it
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.cachedRequest);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream, java.nio.charset.StandardCharsets.UTF_8);

        return new BufferedReader(inputStreamReader);
    }

}
