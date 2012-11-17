/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.perdoctus.synolib.responses;

import java.util.List;

/**
 *
 * @author Christoph Giesche <christoph.giesche@gmx.net>
 */
public class GetAllResponse extends DownloadRedirectorResponse {
    private List<DownloadItem> items;

    public List<DownloadItem> getItems() {
        return items;
    }

    public void setItems(List<DownloadItem> items) {
        this.items = items;
    }
}
