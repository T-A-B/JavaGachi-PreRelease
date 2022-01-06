package webservices.interfaces;

import model.interfaces.IJavaGachi;

public interface IWebserviceCaller {
        boolean openPage();
        String createWebserviceCall(IJavaGachi p_JavaGachi);
}
