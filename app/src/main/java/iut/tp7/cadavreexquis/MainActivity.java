package iut.tp7.cadavreexquis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * Nom de la partie
     */
    private EditText saisieNom;
    /**
     * Type de partie
     */
    private Spinner spinTypePartie;
    private ArrayAdapter<String> adapdateurTypePartie;
    /**
     * Nombre de manches
     */
    private Button bpManchesMoins;
    private TextView txtManches;
    private Button bpManchesPlus;
    /**
     * Nombre de joueurs
     */
    private Button bpJoueursMoins;
    private TextView txtJoueurs;
    private Button bpJoueursPlus;
    /**
     * Choix de la forme de la phrase
     */
    private Button bpFormePhrase;
    /**
     * Thème de la partie
     */
    private Spinner spinTheme;
    private ArrayAdapter<String> adapdateurTheme;
    /**
     * Langue de la partie
     */
    private Spinner spinLangue;
    private ArrayAdapter<String> adapdateurLangue;
    /**
     * Confidentialité de la partie
     */
    private Spinner spinConfidentialite;
    private ArrayAdapter<String> adapdateurConfidentialite;

    /**
     * Bouton inviter un ami
     */
    private Button bpInviter;
    private TextView txtAmis;

    /**
     * Boutons de contrôle
     */
    private Button bpAnnuler;
    private Button bpCreer;

    /**
     * Nombre minimum de manches
     */
    public final int NB_MANCHES_MIN = 1;
    /**
     * Nombre par défaut de manches
     */
    public final int NB_MANCHES_DEFAUT = 5;

    /**
     * Nombre minimum de joueurs
     */
    public final int NB_JOUEURS_MIN = 3;
    /**
     * Nombre par défaut de joueurs
     */
    public final int NB_JOUEURS_DEFAUT = 5;
    /**
     * Nombre maximum de joueurs
     */
    public final int NB_JOUEURS_MAX = 8;

    /**
     * Amis invités dans la partie
     */
    public List<Boolean> amisInvites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* On lie les attributs avec la vue */
        saisieNom = (EditText) findViewById(R.id.saisieNom);
        spinTypePartie = (Spinner) findViewById(R.id.spinTypePartie);
        bpManchesMoins = (Button) findViewById(R.id.bpManchesMoins);
        txtManches = (TextView) findViewById(R.id.txtManches);
        bpManchesPlus = (Button) findViewById(R.id.bpManchesPlus);
        bpJoueursMoins = (Button) findViewById(R.id.bpJoueursMoins);
        txtJoueurs = (TextView) findViewById(R.id.txtJoueurs);
        bpJoueursPlus = (Button) findViewById(R.id.bpJoueursPlus);
        bpFormePhrase = (Button) findViewById(R.id.bpFormePhrase);
        spinTheme = (Spinner) findViewById(R.id.spinTheme);
        spinLangue = (Spinner) findViewById(R.id.spinLangue);
        spinConfidentialite = (Spinner) findViewById(R.id.spinConfidentialite);
        bpInviter = (Button) findViewById(R.id.bpInviter);
        txtAmis = (TextView) findViewById(R.id.txtAmis);
        bpAnnuler = (Button) findViewById(R.id.bpAnnuler);
        bpCreer = (Button) findViewById(R.id.bpCreer);

        /* On initialise les spinners */
        adapdateurTypePartie = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.typesPartie));
        adapdateurTypePartie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTypePartie.setAdapter(adapdateurTypePartie);

        adapdateurTheme = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.themes));
        adapdateurTheme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTheme.setAdapter(adapdateurTheme);

        adapdateurLangue = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.langues));
        adapdateurLangue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLangue.setAdapter(adapdateurLangue);

        adapdateurConfidentialite = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.confidentialites));
        adapdateurConfidentialite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinConfidentialite.setAdapter(adapdateurConfidentialite);

        /* On initialise la liste des amis invité */
        amisInvites = new ArrayList<Boolean>();
        amisInvites.add(false); // ami1
        amisInvites.add(false); // ...
        amisInvites.add(false);

        /* On place un écouteur sur le type de partie */
        spinTypePartie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position < 4) {
                    txtManches.setText(getResources().getStringArray(R.array.typesPartieNb)[position]);
                    bpManchesMoins.setEnabled(false);
                    bpManchesPlus.setEnabled(false);
                } else { // personnalisée
                    bpManchesMoins.setEnabled(true);
                    bpManchesPlus.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

        /* On initialise les nombres */
        txtManches.setText(String.valueOf(NB_MANCHES_DEFAUT));
        txtJoueurs.setText(String.valueOf(NB_JOUEURS_DEFAUT));


        // TODO continuer à initialiser

    }


    /**
     * Incrémente le nombre de manches
     *
     * @param view
     */
    public void incrementerNbManches(View view) {
        int nbManches = Integer.valueOf(txtManches.getText().toString());
        nbManches++;
        txtManches.setText(String.valueOf(nbManches));

        // TODO si nbManches correspond à une possibilité des nombres prédéfinis

        bpManchesMoins.setEnabled(true);
    }

    /**
     * Décrémente le nombre de manches s'il est au moins égal à 2
     *
     * @param view
     */
    public void decrementerNbManches(View view) {
        int nbManches = Integer.valueOf(txtManches.getText().toString());
        if (nbManches > NB_MANCHES_MIN) { // on vérifie le nombre de manches
            nbManches--;
            txtManches.setText(String.valueOf(nbManches));
            if (nbManches == NB_MANCHES_MIN) { // si on est au minimum possible, on désactive le bouton moins
                bpManchesMoins.setEnabled(false);
            }
        }

        // TODO si nbManches correspond à une possibilité des nombres prédéfinis
    }

    /**
     * Incrémente le nombre de joueurs
     *
     * @param view
     */
    public void incrementerNbJoueurs(View view) {
        int nbJoueurs = Integer.valueOf(txtJoueurs.getText().toString());
        if (nbJoueurs < NB_JOUEURS_MAX) {
            nbJoueurs++;
            txtJoueurs.setText(String.valueOf(nbJoueurs));
            if (nbJoueurs == NB_JOUEURS_MAX) { // nombre max de joueurs
                bpJoueursPlus.setEnabled(false);
            }
        }
        bpFormePhrase.setEnabled(true);
        bpJoueursMoins.setEnabled(true);
    }

    /**
     * Décrémente le nombre de joueurs s'il est au moins égal à 4
     *
     * @param view
     */
    public void decrementerNbJoueurs(View view) {
        int nbJoueurs = Integer.valueOf(txtJoueurs.getText().toString());
        if (nbJoueurs > NB_JOUEURS_MIN) { // on vérifie le nombre de manches
            nbJoueurs--;
            txtJoueurs.setText(String.valueOf(nbJoueurs));
            if (nbJoueurs == NB_JOUEURS_MIN) { // si on est au minimum possible, on désactive le bouton moins et le paramétrage de la phrase
                bpJoueursMoins.setEnabled(false);
                bpFormePhrase.setEnabled(false);
            }
        }
        bpJoueursPlus.setEnabled(true);
    }


    /**
     * Ouvre la boîte de dialogue permettant de paramétrer la structure de la phrase
     *
     * @param view
     */
    public void parametrerFormePhrase(View view) {
        // TODO algo
    }

    /**
     * Ouvre la boîte de dialogue permettant d'inviter des amis dans la partie
     *
     * @param view
     */
    public void inviterAmis(View view) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View boiteInvitation = getLayoutInflater().inflate(R.layout.inviter_amis, null);
        mBuilder.setView(boiteInvitation);
        mBuilder.setTitle(getResources().getString(R.string.titre_invitation));

        /* On charge les widgets de l'alertdialog */
        final CheckBox cbxAmi1 = (CheckBox) boiteInvitation.findViewById(R.id.cbxAmi1);
        final CheckBox cbxAmi2 = (CheckBox) boiteInvitation.findViewById(R.id.cbxAmi2);
        final CheckBox cbxAmi3 = (CheckBox) boiteInvitation.findViewById(R.id.cbxAmi3);

        /* On initialise */
        cbxAmi1.setText(getResources().getStringArray(R.array.amis)[0]);
        cbxAmi2.setText(getResources().getStringArray(R.array.amis)[1]);
        cbxAmi3.setText(getResources().getStringArray(R.array.amis)[2]);

        /* On regarde si des amis ont déjà été invités */
        if (amisInvites.get(0)) {
            cbxAmi1.setChecked(true);
        }
        if (amisInvites.get(1)) {
            cbxAmi2.setChecked(true);
        }
        if (amisInvites.get(2)) {
            cbxAmi3.setChecked(true);
        }

        mBuilder.setPositiveButton(getResources().getString(R.string.btn_valider_invitation), null);
        mBuilder.setNegativeButton(getResources().getString(R.string.btn_retour_invitation), null);
        final AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();

        /* On override la méthode onclick du bouton ce qui désactive la fermeture de la boîte de dialogue par défaut */
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbxAmi1.isChecked()) {
                    amisInvites.set(0, true);
                } else {
                    amisInvites.set(0, false);
                }
                if (cbxAmi2.isChecked()) {
                    amisInvites.set(1, true);
                } else {
                    amisInvites.set(1, false);
                }
                if (cbxAmi3.isChecked()) {
                    amisInvites.set(2, true);
                } else {
                    amisInvites.set(2, false);
                }

                /* On met à jour la liste des invités */
                mettreAJourListeInvites();
                /* On ferme la boîte de dialogue */
                alertDialog.dismiss();
            }
        });
    }

    /**
     * Met à jour le champ texte contenant la liste des invités
     */
    private void mettreAJourListeInvites() {
        StringBuilder amis = new StringBuilder("");
        for (int indice = 0 ; indice < amisInvites.size() ; indice++) {
            if (amisInvites.get(indice)) { // si vrai
                amis.append(getResources().getStringArray(R.array.amis)[indice] + "\n");
            }
        }
        txtAmis.setText(amis.toString());
    }

    /**
     * Ouvre la boîte de dialogue permettant d'inviter des amis dans la partie
     *
     * @param view
     */
    public void afficherAide(View view) {
        // TODO algo
    }

    /**
     * Annule la création de la partie
     * On ouvre une boîte de dialogue pour demander confirmation
     *
     * @param view
     */
    public void annuler(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Annuler")
                .setMessage("Etes-vous sûr de vouloir annuler la partie ?")
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            /* Clic sur "oui" */
                            public void onClick(DialogInterface dialog, int which) {
                                /* On ferme l'activité */
                                fermerActivite();
                            }
                        })
                .setNegativeButton(android.R.string.cancel, null)
                .create()
                .show();
    }

    /**
     * Ferme l'activité
     */
    public void fermerActivite() {
        finish();
    }

    /**
     * Créé la partie
     *
     * @param view
     */
    public void creer(View view) {
        // TODO algo
    }


}
