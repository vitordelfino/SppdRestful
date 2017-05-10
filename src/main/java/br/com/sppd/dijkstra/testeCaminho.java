package br.com.sppd.dijkstra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testeCaminho {


	public String testar(String arquivo, String a, String b){
		
		try {
			new PreencheArquivo().preencher();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Grafo grafo = new Grafo();
		grafo.setVertices(LerDoArquivo.lerGrafo(arquivo));
		Vertice i1 = new Vertice();
		Vertice i2 = new Vertice();
		i1 = grafo.encontrarVertice(a);
		i2 = grafo.encontrarVertice(b);
		
		List<Vertice> resultado = new ArrayList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		resultado = algoritmo.encontrarMenorCaminhoDijkstra(grafo, i1, i2);
		
		return resultado.toString();
		
	}
}
