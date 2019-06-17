package src.util;

public class RequestWrapper {
    private String  method;
    private String  url;
    private String  host;
    private String  userAgent;
    private String  accept;
    private String  acceptLanguage;
    private String  acceptEncoding;
    private String  connection;
    private String  upgradeInsecureRequests;

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getHost() {
        return host;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getAccept() {
        return accept;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public String getConnection() {
        return connection;
    }

    public String getUpgradeInsecureRequests() {
        return upgradeInsecureRequests;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setAccept(String accept) {
       // System.out.println("哈哈");
        this.accept = accept;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public void setUpgradeInsecureRequests(String upgradeInsecureRequests) {
        this.upgradeInsecureRequests = upgradeInsecureRequests;
    }
}
