package com.bjsxt.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.InputStream;

public class FtpUtils {

    public static void uploadFile(String host, int port, String username, String password, String pathname, String remote, InputStream is) {
        try {
            FTPClient client = new FTPClient();
            client.connect(host, port);
            client.login(username, password);
            if (!client.changeWorkingDirectory(pathname)) {
                client.makeDirectory(pathname);
                client.changeWorkingDirectory(pathname);
            }

            client.setFileType(FTP.BINARY_FILE_TYPE);

            client.storeFile(remote, is);
            client.logout();
            client.disconnect();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
