# Esercizio: Simulatore di Assicurazione Auto 🚗

Questo esercizio fa parte del corso **Java Backend Formatemp** (lezione del 25 giugno 2025) e consiste nella realizzazione di un semplice simulatore di calcolo del preventivo assicurativo auto.

---

## 📌 Obiettivo

L'applicazione richiede all'utente una serie di informazioni personali e relative alla guida, quindi calcola il **prezzo finale dell'assicurazione** in base a:

- Età
- Possesso della patente
- Anni di esperienza alla guida
- Numero di incidenti negli ultimi 5 anni
- Tipo di pacchetto assicurativo scelto

---

## 🧠 Logica implementata

- Solo utenti **maggiorenni (≥18)** e **con patente valida** possono stipulare l'assicurazione.
- Il prezzo base è di `500€`, e subisce variazioni in base a:

| Fattore             | Variazione           |
| ------------------- | -------------------- |
| Età tra 18 e 25     | +20%                 |
| Età tra 26 e 50     | +0                   |
| Età oltre i 50      | -10%                 |
| Esperienza < 2 anni | +50%                 |
| 1 incidente         | +15%                 |
| 2–4 incidenti       | +30%                 |
| ≥5 incidenti        | Assicurazione negata |
| Pacchetto Premium   | +20%                 |
| Pacchetto Gold      | +50%                 |

---

## 📥 Input richiesti

- Età dell’utente
- Possesso della patente (`si` / `no`)
- Anni di esperienza alla guida
- Numero di incidenti
- Tipo di pacchetto assicurativo (`base`, `premium`, `gold`)

---
