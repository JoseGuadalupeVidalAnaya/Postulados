package pp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlador implements Initializable
{
    Operaciones op;
    @FXML
    private TextField sem;
    @FXML
    private TextArea out;
    @FXML
    private void generar(ActionEvent e)
    {
        int x=Integer.parseInt(sem.getText());
        String mensaje="Binario: ";
        String aux=op.binario(x);
        mensaje=mensaje+aux+"\nNLFSR: ";
        aux=op.generar(aux);
        mensaje=mensaje+aux;
        out.setText(mensaje);
        System.out.println(op.p3(aux));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        op=new Operaciones();
    }
}
