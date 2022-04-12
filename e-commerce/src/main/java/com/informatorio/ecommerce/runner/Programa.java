package com.informatorio.ecommerce.runner;

import com.informatorio.ecommerce.entity.Alumno;
import com.informatorio.ecommerce.repository.AlumnoRepository;
import com.informatorio.ecommerce.service.PreciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class Programa implements CommandLineRunner {

    @Autowired
    private AlumnoRepository repository;

    /*private PreciosService preciosService;

    public Programa(PreciosService preciosService) {
        this.preciosService = preciosService;
    }*/

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("Precio incrementado " + preciosService.calcularPrecioIncrementado(0,0.15));*/
        //Alumno alumno = new Alumno("Marge", "Simpson");
        //Alumno alumno2 = new Alumno("Bart", "Simpson");
        //Alumno alumno3 = new Alumno("Lisa", "Simpson");
        //System.out.println(alumno);
        //repository.save(alumno3);
        //System.out.println(repository.findAll());
        System.out.println(repository.findById(4L)
                .orElseThrow(() -> new EntityNotFoundException("No se existe la entidad")));

    }
}
