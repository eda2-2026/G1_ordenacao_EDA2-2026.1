package modelo;

import java.util.*;
/**
     * Classe Dados simula o pré cadastro das filiais e produtos
     * @author Yan Lucas, Felipe Matheus
     * @since 2023
     * @version 1.0
     * 
     */

public class Dados {
		
	private Empresa empresa = new Empresa();
		private Filial filial = new Filial();
		private ArrayList<Filial> filiais = new ArrayList<Filial>();
		private ArrayList<Medicamento> medicamento = new ArrayList<Medicamento>();
		private ArrayList<Cosmetico> cosmetico = new ArrayList<Cosmetico>();
	
    /**
     * Método que gera filiais com nomes realistas 
     */
		public void fillWithSomeData() {
						String[] bairros = {"Asa Sul", "Asa Norte", "Sudoeste", "Lago Sul", "Lago Norte", "Taguatinga"};
						String[] cidades = {"Brasília", "Brasília", "Brasília", "Brasília", "Brasília", "Taguatinga"};
						String[] telefones = {"3321-1000", "3344-2000", "3233-3000", "3366-4000", "3468-5000", "3351-6000"};

		        for (int i = 0; i < bairros.length; i++) {
		        	Filial fil = new Filial("Unidade " + bairros[i], cidades[i], telefones[i]);
					fillCosmeticAndMeds(fil);
		        	empresa.setFiliais(fil);
		        }
		}
    /**
     * Método que gera Medicamentos e Cosmeticos realistas
     */
		
		public void fillCosmeticAndMeds(Filial fil) {
			String[] nomesMed = {"Paracetamol", "Amoxicilina", "Dipirona", "Ibuprofeno", "Omeprazol", "Loratadina"};
			String[] dosagens = {"500mg", "250mg/5ml", "1g", "600mg", "20/mg", "10mg"};
			String[] tipos = {"Analgésico", "Antibiótico", "Antitérmico", "Anti-inflamatório", "Antiácido", "Antialérgico"};

			String[] nomesCos = {"Protetor Solar", "Hidratante Facial", "Shampoo Anticaspa", "Sabonete Líquido", "Creme de Barbear", "Desodorante Roll-on"};
			String[] volumes = {"50g", "100ml", "200ml", "250ml", "150g", "50ml"};
			String[] marcas = {"La Roche", "Nivea", "Head & Shoulders", "Dove", "Bozzano", "Rexona"};

			for (int j = 0; j < nomesMed.length; j++){
				Medicamento med = new Medicamento(nomesMed[j], (j+1)*15, (j+5)*4.50, "202"+(j+4)+"-12-30", "7891010"+j, dosagens[j], tipos[j]);
				Cosmetico cos = new Cosmetico(nomesCos[j], (j+2)*10, (j+10)*3.20, "202"+(j+5)+"-06-15", "7892020"+j, volumes[j], marcas[j]);

				fil.getMedicamento().add(med);
				fil.getCosmetico().add(cos);
			}
		}
		 	
		public void cadastroFilial(Filial f) {
				filiais.add(f);
		}
		public void cadastroMedicamento(Medicamento m) {
				medicamento.add(m);
		}
		public void cadastroCosmetico(Cosmetico c) {
				cosmetico.add(c);
		}
		public Empresa getEmpresa() {
			return empresa;
		}

		public Filial getFilial() {
			return filial;
		}
}
