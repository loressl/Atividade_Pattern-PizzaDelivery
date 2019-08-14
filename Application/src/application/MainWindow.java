package application;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MainWindow extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	public MainWindow() {
        initComponents();
    }
    
    @SuppressWarnings("rawtypes")
	private void initComponents() {

        modelChoosen = new DefaultListModel();
        modelList = new DefaultListModel();
        scrollIngredientsAvailable = new javax.swing.JScrollPane();
        decoratorAvailable = new javax.swing.JList<>();
        scrollIngredientsChosen = new javax.swing.JScrollPane();
        decoratorChosen = new javax.swing.JList<>();
        upIngredients = new javax.swing.JButton();
        downIngredients = new javax.swing.JButton();
        addIngredients = new javax.swing.JButton();
        removeIngredients = new javax.swing.JButton();
        preparePizza = new javax.swing.JButton();
        comboBoxTypePizzas = new javax.swing.JComboBox<>();
        typePizza = new javax.swing.JLabel();
        ingredientsAvailable = new javax.swing.JLabel();
        ingredientsChosen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizza Delivery");
        setBackground(new java.awt.Color(204, 204, 255));

        decoratorAvailable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        decoratorAvailable.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        scrollIngredientsAvailable.setViewportView(decoratorAvailable);

        scrollIngredientsChosen.setViewportView(decoratorChosen);

        upIngredients.setFont(new java.awt.Font("Tahoma", 0, 14));
        upIngredients.setText("UP");

        downIngredients.setFont(new java.awt.Font("Tahoma", 0, 14));
        downIngredients.setText("DOWN");

        addIngredients.setFont(new java.awt.Font("Tahoma", 0, 18));
        addIngredients.setText("<");

        removeIngredients.setFont(new java.awt.Font("Tahoma", 0, 18));
        removeIngredients.setText(">");

        preparePizza.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        preparePizza.setText("Montar Pizza");

        comboBoxTypePizzas.setFont(new java.awt.Font("Tahoma", 0, 14));
        comboBoxTypePizzas.setToolTipText("");

        typePizza.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        typePizza.setText("Tipos de Pizzas:");

        ingredientsAvailable.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        ingredientsAvailable.setText("Ingredientes Disponíveis");

        ingredientsChosen.setFont(new java.awt.Font("Tahoma", 1, 14));
        ingredientsChosen.setText("Ingredientes Escolhidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(preparePizza, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollIngredientsAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removeIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typePizza)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxTypePizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ingredientsAvailable))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollIngredientsChosen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(downIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(upIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ingredientsChosen)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(upIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(downIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxTypePizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typePizza, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingredientsAvailable, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ingredientsChosen, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollIngredientsAvailable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollIngredientsChosen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(removeIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(addIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))))
                .addGap(18, 18, 18)
                .addComponent(preparePizza, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }                                                                                                                                                                                    

    public JButton getUpIngredients() {return upIngredients;}

    public JButton getDownIngredients() {return downIngredients;}

    public JButton getAddIngredients() {return addIngredients;}

    public JButton getRemoveIngredients() {return removeIngredients;}

    public JButton getPreparePizza() {return preparePizza;}
    
    public JList<String> getDecoratorAvailable() {return decoratorAvailable;}
    
    public JList<String> getDecoratorChosen() {return decoratorChosen;}

    @SuppressWarnings("rawtypes")
	public DefaultListModel getModelChoosen() {return modelChoosen;}

    @SuppressWarnings("rawtypes")
	public DefaultListModel getModelList() {return modelList;}

    public void setModelChoosen(@SuppressWarnings("rawtypes") DefaultListModel modelChoosen) {this.modelChoosen = modelChoosen;}

    public void setModelList(@SuppressWarnings("rawtypes") DefaultListModel modelList) {this.modelList = modelList;}

    public JComboBox<String> getComboBoxTypePizzas() {return comboBoxTypePizzas;}
    
    @SuppressWarnings("rawtypes")
	private DefaultListModel modelChoosen;
    @SuppressWarnings("rawtypes")
	private DefaultListModel modelList;
    private JButton addIngredients;
    private JComboBox<String> comboBoxTypePizzas;
    private JList<String> decoratorChosen;
    private JList<String> decoratorAvailable;
    private JButton downIngredients;
    private JLabel ingredientsAvailable;
    private JLabel ingredientsChosen;
    private JButton preparePizza;
    private JButton removeIngredients;
    private JLabel typePizza;
    private JButton upIngredients;
    private JScrollPane scrollIngredientsAvailable;
    private JScrollPane scrollIngredientsChosen; 
}
