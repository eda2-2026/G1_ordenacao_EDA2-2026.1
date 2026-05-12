package modelo;

	/**
	 * Classe que cria Cosméticos e herda da Classe Produto
	 * @author Yan Lucas, Felipe Matheus
	 * @since 2023
	 * @version 1.0
	 * @see volume 			volume do cosmetico
	 * @see marca			marca do cosmetico
	 */

public class Cosmetico extends Produto {
	
	
	private String volume;
	private String marca;
	/**		
     * Método que chama o contrutor da classe Produto
     */

	public Cosmetico() {
		super();
	}
		/**
		 * Método que cria  os cosmeticos
		 * @param nome 		nome do Cosmetico
		 * @param quantidade 		quantidade de cosmeticos que tem na  filial
		 * @param preco				preço do cosmético
		 * @param validade 			validade do cosmético 
		 * @param codigoDeBarra			codigo de barra do cosmético
		 * @param volume 				volume do cosmético
		 * @param marca 				marca do cosmético
		 */
	public Cosmetico(String nome, int quantidade, double preco, String validade, String codigoDeBarra, String volume, String marca) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.validade = validade;
		this.codigoDeBarra = codigoDeBarra;
		this.volume = volume;
		this.marca = marca;
	}
	 @Override
	 public String toString() {
	 return String.format("[COS] %-20s | Qtd: %-4d | R$ %7.2f | Val: %-10s | %s (%s)", 
	 nome, quantidade, preco, validade, volume, marca);
	 }


	//gets e sets do volume
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}

	//gets e sets da marca
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
