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
        int x = Integer.parseInt(sem.getText());
        if (x < 16 && x >= 0)
        {
            String mensaje = "Binario: ";
            String aux = op.binario(x);
            mensaje = mensaje + aux + "\nNLFSR: ";
            aux = op.generar(aux);
            mensaje = mensaje + aux;
            mensaje = mensaje + "\nPostulado 1: " + op.p1(aux) + "\nPostulado 2: " + op.p2(aux) + "\nPostulad 3: " + op.p3(aux);
            out.setText(mensaje);
        }
        else
            out.setText("Ingrese un numero mayor o igual a 0\nY menor a 16");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        sem.setOnKeyTyped(e ->
        {
            if (!"1234567890".contains(e.getCharacter()))
                e.consume();
            if (sem.getText().length() > 1)
                e.consume();
        });
        op = new Operaciones();
    }
}
