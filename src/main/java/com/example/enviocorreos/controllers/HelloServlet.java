package com.example.enviocorreos.controllers;

import java.io.*;

import com.example.enviocorreos.models.EnvioCorreos;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("p") == null ? "" : request.getParameter("p");

        //instanciamos el objeto EnvioCorreos.
        EnvioCorreos envioCorreos = new EnvioCorreos();

        switch (action) {
            case "Enviar":
                //recibimos los valores del formulario

                String correoDestino =request.getParameter("correoDestino");
                String asunto = request.getParameter("asunto");
                String contenido = request.getParameter("contenido");

                /* @nota: aqui puedes hacer validaciones para no poder ingresar valores vacios
                           o incorrectos, recuerda que no se valida en los jsp o en el front */
                envioCorreos.createEmail(correoDestino,asunto,contenido);
                response.sendRedirect(request.getContextPath());
                envioCorreos.sendEmail();
        }


    }

}