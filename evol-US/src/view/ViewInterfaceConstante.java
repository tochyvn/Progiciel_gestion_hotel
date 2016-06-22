package view;

public interface ViewInterfaceConstante {
	
	/* SYSTEME */
	public final static String VIEW_PACKAGE = "/view/";
	public final static String APPLICATION_CSS = VIEW_PACKAGE+"application.css";
	public final static String DEFAULT_CSS = VIEW_PACKAGE+"default.css";
	public final static String ROOT_VIEW = VIEW_PACKAGE+"RootLayout.fxml";
	public final static String ROOT_CONTROLLER = VIEW_PACKAGE+"RootLayoutController.java";
	
	
	/* POPUPS */
	public final static String POPUP_ROOT_VIEW = VIEW_PACKAGE+"composants/popup/PopupOverview.fxml";
	public final static String ADD_RESERVATION_HOTEL_MODAL = VIEW_PACKAGE+"composants/popup/PopupHotelOverview.fxml";
	public final static String ADD_RESERVATION_RESTAURANT_MODAL = VIEW_PACKAGE+"composants/popup/PopupRestaurantOverview.fxml";
	public final static String ADD_RESERVATION_SPA_MODAL = VIEW_PACKAGE+"composants/popup/PopupSpaOverview.fxml";

	/* DIRECTION */
	public final static String STATISTIQUES_VIEW = VIEW_PACKAGE+"directeur/StatistiquesOverview.fxml";
	
	/* UTILISATEURS & CLIENTS */
	public final static String USER_VIEW = VIEW_PACKAGE+"user/UserOverview.fxml";
	public final static String CONNEXION_VIEW = VIEW_PACKAGE+"compte/CompteOverview.fxml";
	public final static String CLIENT_VIEW = VIEW_PACKAGE+"client/ClientOverview.fxml";
	
	/* RESTAURANT */
	public final static String RESERVATION_VIEW = VIEW_PACKAGE+"listeReservation/ListeReservationOverview.fxml";
	public final static String STOCK_VIEW = VIEW_PACKAGE+"restaurant/StockOverview.fxml";
	
	/* CHAMBRES */
	public final static String CHAMBRE_VIEW = VIEW_PACKAGE+"listeChambre/ListeChambreOverview.fxml";
	public final static String ADD_RESERVATION_VIEW = VIEW_PACKAGE+"ajoutReservation/AjoutReservationOverview.fxml";
	public final static String UPDATE_RESERVATION_VIEW = VIEW_PACKAGE+"updateReservation/UpdateReservationOverview.fxml";

	/* HOTEL */
	public final static String AGENCE_VIEW = VIEW_PACKAGE+"hotel/AgenceOverview.fxml";
	public final static String LIVRE_OR_VIEW = VIEW_PACKAGE+"hotel/LivreOrOverview.fxml";
	
	/* RECEPTION */
	public final static String ENCAISSEMENT_VIEW = VIEW_PACKAGE+"reception/EncaissementOverview.fxml";
	public final static String FACTURES_VIEW = VIEW_PACKAGE+"reception/FacturesOverview.fxml";
	public final static String PLANNING_VIEW = VIEW_PACKAGE+"reception/PlanningOverview.fxml";
	public final static String SURMESURE_VIEW = VIEW_PACKAGE+"reception/ServiceOverview.fxml";
	
	/* AUTRES SERVICES */
	public final static String SPA_VIEW = VIEW_PACKAGE+"spa/SpaOverview.fxml";
	public final static String NETTOYAGE_VIEW = VIEW_PACKAGE+"gouvernante/GouvernanteOverview.fxml";
	public final static String REPARATION_HOTEL_VIEW = VIEW_PACKAGE+"maintenance/MaintenanceHotelOverview.fxml";
	public final static String REPARATION_RESTO_VIEW = VIEW_PACKAGE+"maintenance/MaintenanceRestaurantOverview.fxml";
	
	/* MENTIONS LEGALES  */
	public final static String MENTIONS_VIEW = VIEW_PACKAGE+"mentions/MentionsLegalesOverview.fxml";
	
	
}
