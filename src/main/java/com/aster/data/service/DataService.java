package com.aster.data.service;

import com.github.sardine.DavResource;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DataService {

    List<DavResource> list(final String folderLocation) throws Exception;

    boolean exists(final String url) throws Exception;

    List<DavResource> propFind(String url, int depth) throws Exception;

}
