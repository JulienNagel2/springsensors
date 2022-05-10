package org.tanzu.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web")
public class WebProperties {

    private String _tempHeader;
    private String _pressureHeader;
    private String _bannerTextColor;
    private String _bannerText;

    public String getTempHeader() {
        return _tempHeader;
    }

    public void setTempHeader(String tempHeader) {
        _tempHeader = tempHeader;
    }

    public String getPressureHeader() {
        return _pressureHeader;
    }

    public void setPressureHeader(String pressureHeader) {
        _pressureHeader = pressureHeader;
    }

    public String getBannerTextColor() {
        return _bannerTextColor;
    }

    public void setBannerTextColor(String bannerTextColor) {
        _bannerTextColor = bannerTextColor;
    }

    public String getBannerText() {
        return _bannerText;
    }

    public void setBannerText(String bannerText) {
        _bannerText = bannerText;
    }
}
