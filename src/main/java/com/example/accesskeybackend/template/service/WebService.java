package com.example.accesskeybackend.template.service;

import org.springframework.stereotype.Service;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

import java.util.Locale;
import java.util.concurrent.ExecutionException;


@Service
public class WebService {
    private String fixUrl(String url) {
        return url
                .toLowerCase(Locale.ROOT)
                .replaceFirst("^(http[s]?://www\\.|http[s]?://|www\\.)","")
                .split("/")[0];
    }

    public boolean checkIpv6(String name){
        name = fixUrl(name);
        Record[] records = new Record[0];
        try {
            records = new Lookup(name, Type.AAAA).run();
        } catch (TextParseException e) {
            e.printStackTrace();
        }
        return !(records==null);
    }
}
