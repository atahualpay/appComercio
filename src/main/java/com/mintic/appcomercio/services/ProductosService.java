package com.mintic.appcomercio.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.mintic.appcomercio.models.ProductosModel;
import com.mintic.appcomercio.repositories.ProductosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductosService {
    String directory = "c:\\upload";
    String line = "";
    // String directoryName = PATH.concat(this.getClassName());

    @Autowired
    private ProductosRepository IProduct;

    public void guardaProductos(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File dir = new File(directory);
        if (!dir.exists())
            dir.mkdirs();
        try {

            file.transferTo(new File("c:\\upload\\" + fileName));
            cargarProductos(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarProductos(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("c:\\upload\\" + fileName));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ProductosModel pr = new ProductosModel();
                pr.setCodigo_producto(Long.parseLong(data[0]));
                pr.setIvacompra(Integer.parseInt(data[1]));
                pr.setNombre_producto(data[2]);
                pr.setPrecio_compra(Double.parseDouble(data[3]));
                pr.setPrecio_venta(Double.parseDouble(data[4]));
                pr.setNitproveedor(Long.parseLong(data[5]));
                IProduct.save(pr);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
