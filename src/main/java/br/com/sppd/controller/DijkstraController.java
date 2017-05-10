package br.com.sppd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.xml.internal.ws.addressing.ProblemAction;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dbms.dao.EstacaoDAO;
import br.com.sppd.dijkstra.Dijkstra;
import br.com.sppd.dijkstra.Grafo;
import br.com.sppd.dijkstra.LerDoArquivo;
import br.com.sppd.dijkstra.Vertice;
import jdk.nashorn.internal.scripts.JS;

/**
 * 
 * Classe respons�vel por ser o controller Resource e Dijkstra
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 30 de mar de 2017
 *
 */
public class DijkstraController {
	public List<Estacao> encontrarMenorCaminhoDijkstra(String origem, String destino) {
		
		/*
		 * Leitura dos arquivos com as conec�es das esta��es
		 */
		Grafo grafo = new Grafo();
		//grafo.setVertices(LerDoArquivo.lerGrafo("C:\\Workspace\\Eclipse\\WebServiceRestSppd\\Grafo.txt"));
		grafo.setVertices(LerDoArquivo.lerGrafo("Grafo.txt"));
		Vertice v1 = new Vertice();
		Vertice v2 = new Vertice();
		v1 = grafo.encontrarVertice(origem);
		v2 = grafo.encontrarVertice(destino);
		List<Vertice> lv = new Dijkstra().encontrarMenorCaminhoDijkstra(grafo, v1, v2);
		
		
		
		/*
		 * Leitura do arquivo propertie com o codigo da linha
		 */
		Properties p = new Properties();
		File f = new File("C:\\Workspace\\Eclipse\\WebServiceSPPD\\EstacaoPropertie.propertie");
		try {
			InputStream is = new FileInputStream(f);
			p.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Montagem do retorno inserindo em uma lista o nome da estacao e o cod buscado no arq propertie
		 */
		List<Estacao> estacoes = new ArrayList<Estacao>();
		lv.forEach(v -> {
			String nomeEstacao = v.getDescricao();

			estacoes.add(new Estacao(nomeEstacao,
					Integer.parseInt(
							p.getProperty(Normalizer.normalize(nomeEstacao.replaceAll(" ", ""), Normalizer.Form.NFD)
									.replaceAll("[^\\p{ASCII}]", "")))));
			;

		});

		return estacoes;
	}
}
