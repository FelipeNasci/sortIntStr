package view;

import controller.Controller;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View implements ActionListener {

    private JFrame frame;
    private JPanel panel;

    private TextArea unsortedTextArea;
    private TextArea sortedTextArea;

    private JScrollPane scrool;

    private JButton sortButton;
    private JButton fileButton;

    public View() {

        init();
        defineLayout();
        dimensions();

        sortButton.addActionListener(this);
        fileButton.addActionListener(this);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**************************************************
     * Inicializando variáveis *
     *************************************************/
    private void init() {
        frame = new JFrame();
        panel = new JPanel();

        unsortedTextArea = new TextArea("Vetor Não Ordenado");
        sortedTextArea = new TextArea("Vetor Ordenado");

        scrool = new JScrollPane();
        sortButton = new JButton("Sort");
        fileButton = new JButton("Procurar arquivo");
    }

    /*****************************************
     * Definindo a posição de cada componente
    ******************************************/
    private void defineLayout() {

        frame.add(scrool);

        panel.setLayout(new FlowLayout());

        panel.add(fileButton);
        panel.add(unsortedTextArea);
        panel.add(sortButton);
        panel.add(sortedTextArea);

    }

    /***********************************
     * Dimensao dos elementos da tela 
     **********************************/
    private void dimensions() {
        frame.setSize(500, 500);

        unsortedTextArea.setSize(0, 0);

    }

    private void findFile() {
        
        try {

            //Configurando o meu JFileChooser
            JFileChooser jfc = new JFileChooser();
            //Configura o filtro de seleção
            jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de Texto (*.txt)", "txt"));
            //Configura o Label do botão de seleção
            jfc.setApproveButtonText("Selecionar Texto");
            //Configura o Título da caixa de Dialogo
            jfc.setDialogTitle("Buscar Texto");
            //Configura a possíbilidade de selecionar vários arquivos
            jfc.setAcceptAllFileFilterUsed(false);

            int returnVal = jfc.showOpenDialog(unsortedTextArea);// Obs.: Esse "this" do argumento permite que o icone de canto do seu frame seja herdado deste.
            
            if (!(returnVal == JFileChooser.APPROVE_OPTION)) { // Teste o usuário seleionou algo
                return;
            }
            
            File file = jfc.getSelectedFile();
            String content = Controller.gerFile(file.getPath());
            
            unsortedTextArea.setText(content);
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == sortButton) {
            String content = Controller.sort(unsortedTextArea.getText());
            sortedTextArea.setText(content);
            
        } else if (ae.getSource() == fileButton) {
            findFile();
        }
    }
}
