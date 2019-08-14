package application;

import interfaces.IUIController;
import interfaces.Pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class UIController implements IUIController {

	@Override
	public boolean initialize() {
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		listItensDecorators = Core.getInstance().getPluginController().getPluginsDecorators();
		plugins = Core.getInstance().getPluginController().getPlugins();
		URL[] jars = Core.getInstance().getPluginController().getJars();
		URLClassLoader ulc = new URLClassLoader(jars);
		loadItensComboBox(ulc);
		activeButtons(false);

		mainWindow.getComboBoxTypePizzas().removeAllItems();
		for (String comboBox : comboItens)
			mainWindow.getComboBoxTypePizzas().addItem(comboBox);
		mainWindow.getComboBoxTypePizzas().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemSelectedCombox = (String) mainWindow.getComboBoxTypePizzas().getSelectedItem();
				if (!itemSelectedCombox.equalsIgnoreCase("<Escolha o tipo de pizza>")) {
					mainWindow.getDecoratorAvailable().setModel(mainWindow.getModelList());
					for (String itemDecorator : listItensDecorators)
						mainWindow.getModelList().addElement(itemDecorator);
					activeButtons(true);
				} else {
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
				int ingredientsChoosen = mainWindow.getModelChoosen().getSize();
				List<String> newInstances = new ArrayList<>();
				for (int i = 0; i < ingredientsChoosen; i++) 
					for (int j = 0; j < plugins.length; j++) {
						String pluginName = plugins[j].split("\\.")[0];
						if (mainWindow.getModelChoosen().getElementAt(i).equals(plugins[j].split("D")[0])) {
							newInstances.add(pluginName);
							break;
						}
					}
				Pizza pizza = preparePizza(ulc,newInstances);
				pizza.mountPizza();
				JOptionPane.showMessageDialog(mainWindow, "Pizza preparada com sucesso!! ");
				mainWindow.getModelChoosen().removeAllElements();
			}
		});
		return true;
	}

	private void activeButtons(boolean state) {
		mainWindow.getUpIngredients().setEnabled(state);
		mainWindow.getDownIngredients().setEnabled(state);
		mainWindow.getAddIngredients().setEnabled(state);
		mainWindow.getRemoveIngredients().setEnabled(state);
		mainWindow.getPreparePizza().setEnabled(state);
	}

	private void loadItensComboBox(URLClassLoader ulc) {
		comboItens.add("<Escolha o tipo de pizza>");
		List<String> decorators = Core.getInstance().getPluginController().getPluginsPizzas();
		for (String decorator : decorators) {
			Pizza pizza = null;
			try {
				Class<?> pluginClass = Class.forName(decorator.toLowerCase() + "." + decorator, true, ulc);
				pizza = (Pizza) pluginClass.newInstance();
				comboItens.add(pizza.getDescription());
				listPizzas.add(pizza);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Pizza preparePizza(URLClassLoader ulc, List<String> list) {
		Pizza pizza = pizzaChoosen();
		for (String objects : list) {
			try {
				Class<?> pluginClass = Class.forName(objects.toLowerCase() + "." + objects, true, ulc);
				Constructor<?>[] pluginConstructors = pluginClass.getDeclaredConstructors();
				for (Constructor<?> constructor : pluginConstructors)
					pizza = (Pizza) constructor.newInstance(pizza);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pizza;
	}

	private Pizza pizzaChoosen() {
		for (Pizza pizza : listPizzas)
			if (pizza.getDescription().equalsIgnoreCase(itemSelectedCombox))
				return pizza;
		return null;
	}

	private MainWindow mainWindow;
	private List<String> comboItens = new ArrayList<>();
	private List<Pizza> listPizzas = new ArrayList<>();
	private List<String> listItensDecorators = new ArrayList<>();
	private String itemSelectedCombox = null;
	private String[] plugins;
}
