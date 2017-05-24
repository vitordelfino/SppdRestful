package br.com.sppd.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dbms.dao.EstacaoDAO;
import br.com.sppd.dijkstra.Dijkstra;
import br.com.sppd.dijkstra.Grafo;
import br.com.sppd.dijkstra.LerDoArquivo;
import br.com.sppd.dijkstra.Vertice;

/**
 * 
 * Classe responsável por ser o controller Resource e Dijkstra
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 30 de mar de 2017
 *
 */
public class DijkstraController {
	public List<Estacao> encontrarMenorCaminhoDijkstra(int origem, int destino) {

		/*
		 * Leitura dos arquivos com as conexões das estações
		 */
		Grafo grafo = new Grafo();
		URL path = LerDoArquivo.class.getResource("Grafo.txt");
		grafo.setVertices(LerDoArquivo.lerGrafo(path.getFile()));
		Vertice v1 = new Vertice();
		Vertice v2 = new Vertice();
		v1 = grafo.encontrarVertice(String.valueOf(origem));
		v2 = grafo.encontrarVertice(String.valueOf(destino));
		List<Vertice> lv = new Dijkstra().encontrarMenorCaminhoDijkstra(grafo, v1, v2);

		/*
		 * Leitura do arquivo propertie com o codigo da linha
		 */
		Properties p = new Properties();
		//File f = new File("C:\\Workspace\\Eclipse\\WebServiceSPPD\\EstacaoPropertie.propertie");
		URL path2 = LerDoArquivo.class.getResource("EstacaoPropertie.propertie");
		File f = new File(path2.getFile());
		try {
			InputStream is = new FileInputStream(f);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String linha = "";
			while ((linha = b.readLine()) != null) {
				System.out.println("linha: " + linha);
			}
			
			
			p.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Montagem do retorno inserindo em uma lista o nome da estacao e o cod
		 * buscado no arq propertie
		 */
		List<Estacao> estacoes = EstacaoDAO.getInstance().getEstacao(lv);
		

		return estacoes;
	}
}
