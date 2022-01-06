package controller.interfaces;

import model.interfaces.IJavaGachiFriendListModel;
import view.interfaces.IFriendListScreenView;

public interface IFriendListController {
    IJavaGachiFriendListModel getModel();

    IFriendListScreenView getView();

    void setModel(IJavaGachiFriendListModel p_model);

    void setView(IFriendListScreenView p_view);

    void initialize();

    void bind(IFriendListScreenView p_view, IJavaGachiFriendListModel p_model);

    void populateJList();


}
