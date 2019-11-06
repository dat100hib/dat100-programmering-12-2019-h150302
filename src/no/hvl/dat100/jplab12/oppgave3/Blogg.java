package no.hvl.dat100.jplab12.oppgave3;


import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	private int nesteLedig;
	private Innlegg[] tabell;

	public Blogg() {
		this.tabell = new Innlegg[20];
		this.nesteLedig = 0;

	}

	public Blogg(int lengde) {
		this.tabell = new Innlegg[lengde];
		this.nesteLedig = 0;

	}

	public int getAntall() {

		return nesteLedig;
	}

	public Innlegg[] getSamling() {
		
		return tabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		int p = -1;
		int i = 0;
		while (i < nesteLedig && p == -1) {
			if (tabell[i].erLik(innlegg)) {
				p = i;
			}
			i++;
		}
		return p;

	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		int p = finnInnlegg(innlegg);
		if (p >= 0) {
			finnes = true;
		}

		return finnes;
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		if (nesteLedig < tabell.length) {
			ledig = true;
		}

		return ledig;

	}

	public boolean leggTil(Innlegg innlegg) {

		boolean lagtTil = false;
		if (ledigPlass() && !finnes(innlegg)) {
			tabell[nesteLedig] = innlegg;
			lagtTil = true;
			nesteLedig++;
		}

		return lagtTil;

	}

	public String toString() {
		Innlegg[] tabell = getSamling();
		int antall = getAntall();
		String str = "";
		for (int i = 0; i < antall; i++) {

			str += tabell[i];
		}
		str = antall + "\n" + str;

		return str;

	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] utvidet = new Innlegg[tabell.length*2];
		for(int i = 0; i<tabell.length; i++) {
			utvidet[i] = tabell[i];
		}
		tabell = utvidet;
		
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtInn = false;
		if (!finnes(innlegg)) {
			if(nesteLedig==tabell.length) {
				utvid();
			}
				leggTil(innlegg);
				lagtInn = true;
				
		} 
			
		
		return lagtInn;

	}

	public boolean slett(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if(finnes(innlegg)) {
			tabell[pos] = null;
			for(int j = pos; j < nesteLedig - 1; j++){
                tabell[j] = tabell[j+1];
            }
			nesteLedig--;
		return true;
		}else {
			return false;
		}
			
		
		
	}

	public int[] search(String keyword) {
		int j = 0;
		int[] midlertidig = new int [tabell.length];
		for(int i = 0; i<tabell.length; i++) {
			if(tabell[i].toString().contains(keyword)) {
				midlertidig[j] = tabell[i].getId();
				j++;
			}
		}
		int [] id = new int[j];
		for (int i = 0; i<id.length; i++) {
			id[i] = midlertidig[i];
		}
		return id;

	}
}