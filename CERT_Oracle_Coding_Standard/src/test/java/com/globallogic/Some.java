package com.globallogic;

import org.junit.Test;

import java.text.Normalizer;

public class Some {

    @Test
    public void name() {
        String s = "\uFE64" + "script" + "\uFE65";
//        System.out.println(s);
        System.out.println(s + "  ---vs---  " + Normalizer.normalize(s, Normalizer.Form.NFKC));
        System.out.println(Normalizer.normalize("   /AAA/./.../asf/   a", Normalizer.Form.NFKC));
    }

}
