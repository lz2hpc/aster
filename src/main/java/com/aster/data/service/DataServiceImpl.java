package com.aster.data.service;

import com.github.sardine.DavResource;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataServiceImpl implements DataService {

    private static final String USERNAME = "omicron";
    private static final String PASSWORD = "yNdhyh5CgdabuYHTG9bj";

    public List<DavResource> list(String url) throws Exception {
        Sardine sardine = SardineFactory.begin(USERNAME, PASSWORD);
        return sardine.list(url);
    }

    public boolean exists(String url) throws Exception {
        Sardine sardine = SardineFactory.begin(USERNAME, PASSWORD);
        return sardine.exists(buildIRI(url));
    }

    private String buildIRI(String urlString) throws URISyntaxException {
        URI uri = new URI(urlString);
        return new URI(uri.getScheme(),
                USERNAME + ":"  + PASSWORD,
                uri.getHost(),
                uri.getPort(),
                uri.getPath(),
                uri.getQuery(),
                uri.getFragment()).toString();
    }

    public List<DavResource> propFind(String url, int depth) throws Exception {
        Sardine sardine = SardineFactory.begin(USERNAME, PASSWORD);
        QName qname = new QName("http://my.namespace.com", "checksum", "zz1");
        Set<QName> propertiesSet = new HashSet<>();
        propertiesSet.add(qname);
        List<DavResource> propertiesList = sardine.propfind(url, -1, propertiesSet);
        printAllResourcesForLevel(propertiesList);
        return null;
    }

    public void printAllResourcesForLevel (List<DavResource> resources) throws Exception {
        for (DavResource res : resources)
        {
            System.out.println(res); // calls the .toString() method.
        }
    }

}
