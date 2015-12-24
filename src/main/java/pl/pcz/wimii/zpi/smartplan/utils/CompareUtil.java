/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.utils;

/**
 *
 * @author Radek
 */
public class CompareUtil {

    public static <T extends Comparable<T>> int cp(T a, T b) {
        return a == null
                ? (b == null ? 0 : Integer.MIN_VALUE)
                : (b == null ? Integer.MAX_VALUE : a.compareTo(b));
    }
}
