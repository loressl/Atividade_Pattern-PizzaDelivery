package application;

import interfaces.IUIController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UIController implements IUIController {

    @Override
    public boolean initialize() {
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        activeButtons(false);
        
        mainWindow.getComboBoxTypePizzas().removeAllItems();
        for(String s: comboTeste)
            mainWindow.getComboBoxTypePizzas().addItem(s);
        mainWindow.getComboBoxTypePizzas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemSelected = (String) mainWindow.getComboBoxTypePizzas().getSelectedItem();
               if(!itemSelected.equalsIgnoreCase("<Escolha o tipo de pizza>")){
                   mainWindow.getDecoratorAvailable().setModel(mainWindow.getModelList());
                   for(String s: listItemsTeste)
                       mainWindow.getModelList().addElement(s);
                   activeButtons(true);
               }else{
                   activeButtons(false);
                   mainWindow.getModelList().removeAllElements();
                   mainWindow.getModelChoosen().removeAllElements();
               }     
            }
        });
        
        mainWindow.getUpIngredients().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = mainWindow.getDecoratorChosen().getSelectedValue();
                int itemIndex = mainWindow.getDecoratorChosen().getSelectedIndex();
                DefaultListModel model = (DefaultListModel) mainWindow.getDecoratorChosen().getModel();
                if (itemIndex > 0) {
                    model.remove(itemIndex);
                    model.add(itemIndex - 1, selectedItem);
                    mainWindow.getDecoratorChosen().setSelectedIndex(itemIndex - 1);
                }
            }
        });
        mainWindow.getDownIngredients().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = mainWindow.getDecoratorChosen().getSelectedValue();
                int itemIndex = mainWindow.getDecoratorChosen().getSelectedIndex();
                DefaultListModel model = (DefaultListModel) mainWindow.getDecoratorChosen().getModel();
                if (itemIndex < model.getSize() - 1) {
                    model.remove(itemIndex);
                    model.add(itemIndex + 1, selectedItem);
                    mainWindow.getDecoratorChosen().setSelectedIndex(itemIndex + 1);
                }
            }
        });
        mainWindow.getAddIngredients().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int itemIndex = mainWindow.getDecoratorChosen().getSelectedIndex();
                if (itemIndex != -1) {
                    mainWindow.setModelChoosen((DefaultListModel) mainWindow.getDecoratorChosen().getModel());
                    mainWindow.getModelChoosen().remove(itemIndex);
                }
            }
        });
        mainWindow.getRemoveIngredients().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getModelChoosen().addElement(mainWindow.getDecoratorAvailable().getSelectedValue());
                mainWindow.getDecoratorChosen().setModel(mainWindow.getModelChoosen());
            }
        });
        mainWindow.getPreparePizza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(mainWindow, "Pizza preparada com sucesso!!");
            }
        });
        return true;
    }
    
    private void activeButtons(boolean state){
       mainWindow.getUpIngredients().setEnabled(state);
       mainWindow.getDownIngredients().setEnabled(state);
       mainWindow.getAddIngredients().setEnabled(state);
       mainWindow.getRemoveIngredients().setEnabled(state);
       mainWindow.getPreparePizza().setEnabled(state);
    }

    private String[] comboTeste={"<Escolha o tipo de pizza>", "Pizza Básica"};
    private String[] listItemsTeste = {"Presunto", "Azeitona", "Frango"}; 
    
    private MainWindow mainWindow;
    private List<String> listItens = new ArrayList<>();
    private List<String> comboItens = new ArrayList<>();
}
