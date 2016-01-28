/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.utils;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import pl.pcz.wimii.zpi.smartplan.json.beans.ZjazdyJSON;

/**
 *
 * @author Radek
 */
public class DateUtil {

    public static ZjazdyJSON getDateNearest(List<ZjazdIData> dates, Date targetDate) {
        
        ZjazdIData zjazdiData = new ZjazdIData(targetDate, null);
        dates.add(zjazdiData);
        TreeSet<ZjazdIData> treeSet = new TreeSet<>(dates);
        ZjazdIData zjazdTmp = treeSet.higher(zjazdiData);
        
        if (zjazdTmp == zjazdiData || zjazdTmp == null) {
            zjazdTmp = treeSet.lower(zjazdiData);
            
        }
        return zjazdTmp.getZjazd();
    }
}
