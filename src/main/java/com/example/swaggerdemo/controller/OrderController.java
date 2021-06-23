package com.example.swaggerdemo.controller;

import com.example.swaggerdemo.service.PdfService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final PdfService pdfService;

    @Autowired
    public OrderController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/download-pdf")
    public void downloadPDFResource(HttpServletResponse response) {
        try {
            Path file = Paths.get(pdfService.generatePdf().getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }


//    @Autowired
//    ServletContext servletContext;
//
//    private final TemplateEngine templateEngine;
//
//    public OrderController(TemplateEngine templateEngine) {
//        this.templateEngine = templateEngine;
//    }

//    @RequestMapping(path = "/pdf")
//    public ResponseEntity<?> getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        /* Do Business Logic*/
//
//        Order order = OrderHelper.getOrder();
//
//        /* Create HTML using Thymeleaf template Engine */
//
//        WebContext context = new WebContext(request, response, servletContext);
//        context.setVariable("orderEntry", order);
//        String orderHtml = templateEngine.process("order", context);
//
//        /* Setup Source and target I/O streams */
//
//        ByteArrayOutputStream target = new ByteArrayOutputStream();
//
//        /*Setup converter properties. */
//        ConverterProperties converterProperties = new ConverterProperties();
//        converterProperties.setBaseUri("http://localhost:8080");
//
//        /* Call convert method */
//        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
//
//        /* extract output as bytes */
//        byte[] bytes = target.toByteArray();
//
//
//        /* Send the response as downloadable PDF */
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(bytes);
//
//    }
}
