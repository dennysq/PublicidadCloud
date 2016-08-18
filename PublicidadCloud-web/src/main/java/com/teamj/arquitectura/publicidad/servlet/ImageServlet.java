/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.servlet;

import com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampania;
import com.teamj.arquitectura.publicidad.services.SegmentoDetalleCampaniaServicio;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Dennys
 */
@WebServlet(name = "imagePublicidad", urlPatterns = {"/imagePublicidad"})
public class ImageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //String imagesPath = "C:\\hitchus";
    String imagesPath = "/home/ec2-user/hitchus";
    @EJB
    SegmentoDetalleCampaniaServicio sdc;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String base64Image = "";
        int edad = Integer.parseInt(request.getParameter("edad"));
        String genero = request.getParameter("genero");
        List<SegmentoDetalleCampania> tempServicio = sdc.retrieveSegmentoDetalleCampServ();
        
        List<Integer> listaAuxiliar = new ArrayList<>();
        
        for (int i = 0; i < tempServicio.size(); i++) {
            if (edad >= tempServicio.get(i).getTargetEdad().getEdadMinima() && edad < tempServicio.get(i).getTargetEdad().getEdadMaxima() && tempServicio.get(i).getTargetEdad().getGenero().equals(genero)) {
                //base64Image = tempServicio.get(i).getElemento().getPath();
                listaAuxiliar.add(i);
            }
        }
        
        Random r = new Random();
        int rValue=r.nextInt(listaAuxiliar.size());
        base64Image = tempServicio.get(listaAuxiliar.get(rValue)).getElemento().getPath();
        
        byte[] imageByteArray = decodeImage(base64Image);

        response.setHeader("Content-Type", "image/jpg;image/png");
        response.setHeader("Content-Length", String.valueOf(imageByteArray.length));
        response.setHeader("Content-Disposition", "inline; filename=\"publicidad.jpg\"");                
        
        //    System.out.println("" + file.getAbsolutePath());
        ByteArrayInputStream in = new ByteArrayInputStream(imageByteArray);
        IOUtils.copy(in, response.getOutputStream());
        //Files.copy(file.toPath(), response.getOutputStream());

    }

    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
