package controller.interfaces;

import model.interfaces.IJavaGachi;
import view.interfaces.ICharacterCreationScreenView;

import java.awt.*;

public interface ICharacterCreationScreenController {
    IJavaGachi getModel();

    ICharacterCreationScreenView getView();

    void setModel(IJavaGachi p_model);

    void setView(ICharacterCreationScreenView p_view);

    void initialize();

    void bind(ICharacterCreationScreenView p_view, IJavaGachi p_model);



    Color getSpriteColorFromUser();

    Color getEyeColorFromUser();

    void doFinalize();

    boolean isFinalized();


}
