package com.estudos.sitevendas;

import com.estudos.sitevendas.Repository.CidadeRepository;
import com.estudos.sitevendas.Repository.EstadoRepository;
import com.estudos.sitevendas.model.Cidade;
import com.estudos.sitevendas.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SitevendasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SitevendasApplication.class, args);
	}

	@Autowired
	private CidadeRepository cidadeRespository;

	@Autowired
	private EstadoRepository estadoRespository;



	@Override
	public void run(String... args) throws Exception {


		Estado e1 = new Estado(null,"Mato Grosso do Sul");
		Cidade c1 = new Cidade(null, "Campo Grande",e1);

		e1.getCidades().add(c1);

		estadoRespository.save(e1);
		cidadeRespository.save(c1);

	}
}
