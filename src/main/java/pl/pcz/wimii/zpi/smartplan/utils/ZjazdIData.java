/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.utils;

import java.util.Date;
import java.util.Objects;
import pl.pcz.wimii.zpi.smartplan.json.beans.ZjazdyJSON;

/**
 *
 * @author Radek
 */
public class ZjazdIData implements Comparable<ZjazdIData>{
        private Date data;
        private ZjazdyJSON zjazd;

        public ZjazdIData(Date data, ZjazdyJSON zjazd) {
            this.data = data;
            this.zjazd = zjazd;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }

        public ZjazdyJSON getZjazd() {
            return zjazd;
        }

        public void setZjazd(ZjazdyJSON zjazd) {
            this.zjazd = zjazd;
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ZjazdIData other = (ZjazdIData) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ZjazdIData o) {
        return this.getData().compareTo(o.getData());
    }
        
    }
