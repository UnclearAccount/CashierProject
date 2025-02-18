package update;
import home.VCHome;
import input.InputModel;
import input.InputView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class UpdateController {
    UpdateModel updateModel;
    UpdateView updateView;
    String productName;
    boolean checking = false;
    public UpdateController(UpdateModel updateModel, UpdateView updateView){
        this.updateModel = updateModel;
        this.updateView = updateView;
        String data[][] = updateModel.findAllProduct();
        updateView.listProduct.setModel((new JTable(data, updateView.colom)).getModel());
        updateView.listProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mousePressed(e);
                int row = updateView.listProduct.getSelectedRow();
                int col = updateView.listProduct.getSelectedColumn();
                updateView.listProduct.getValueAt(row,0).toString();
            }                
        });            
        updateView.pback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                super.mouseClicked(me);
                updateView.layout.setVisible(false);
                VCHome vcHome = new VCHome();
            }
        });
        updateView.tfIdProduct.addActionListener(new ActionListener() {//Action jika di Pencet Add
            @Override
            public void actionPerformed(ActionEvent e) {
               String productID = updateView.getIdProduct();
               updateModel.checkingData(productID);
                if(updateModel.checking == true){
                   updateView.setNameProduct(updateModel.productName);
                   updateView.setPrice(updateModel.productPrice);
                   updateView.setProfit(updateModel.productProfit);
                   updateView.setStock(updateModel.productStock);
               }
                else{
                    JOptionPane.showMessageDialog(null, "NOT FOUND '"+productID+"' IN DATABASE");
                    updateView.setNameProduct("");
                    updateView.setPrice("");
                    updateView.setProfit("");
                    updateView.setStock("");
                    updateView.setProductID("");
                }
            }
        });
        updateView.pupdate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                super.mouseClicked(me);
                if(updateModel.checking == true){
                String productID = updateView.tfIdProduct.getText();
                String tempPrice = updateView.tfUpdateProductPrice.getText();
                int price = Integer.parseInt(tempPrice);
                String tempProfit = updateView.tfUpdateProfit.getText();
                int profit = Integer.parseInt(tempProfit);
                String tempStock = updateView.tfUpdateStock.getText();
                int stock = Integer.parseInt(tempStock);
                updateModel.UpdateData(productID, price, profit, stock);
                String data[][] = updateModel.findAllProduct();
                updateView.listProduct.setModel((new JTable(data, updateView.colom)).getModel());
                }
            }  
        });            
    }    
}