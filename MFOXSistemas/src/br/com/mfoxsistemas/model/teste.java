package br.com.mfoxsistemas.model;


import br.com.mfoxsistemas.bo.QuemSomosBO;

public class teste {

	public static void main(String[] args) {
		QuemSomos qs = new QuemSomos();
		QuemSomosBO bo = new QuemSomosBO();
		try {
			qs = bo.getAtivo();
			for(Paragrafo p :qs.getSomos()){
				System.out.println(p.getId()+" - "+p.getTexto());
			}
		} catch (Exception e) {
			System.out.println("DEU ERRO");
			e.printStackTrace();
		}

	}

}
