import GoogleMaps

class HybridMapView: HybridMapViewSpec {
    var children: Variant_MapViewChildren__MapViewChildren_? = nil {
        didSet {
            mapView.clear()

            guard let children = children else {
                return
            }

            if case let .first(child) = children {
                let gmsMarker = GMSMarker()
                gmsMarker.position = CLLocationCoordinate2D(latitude: child.props.latitude, longitude: child.props.longitude)
            } else if case let .second(childArray) = children {
                for marker in childArray {
                    let gmsMarker = GMSMarker()
                    gmsMarker.position = CLLocationCoordinate2D(latitude: marker.props.latitude, longitude: marker.props.longitude)
                    gmsMarker.map = mapView
                }
            }
        }
    }

    var latitude: Double = 0.0 {
        didSet {
            updateMapCamera()
        }
    }

    var longitude: Double = 0.0 {
        didSet {
            updateMapCamera()
        }
    }

    var zoom: Double = 0.0 {
        didSet {
            updateMapCamera()
        }
    }

    var view: UIView = .init()
    private var mapView: GMSMapView!

    override init() {
        let camera = GMSCameraPosition.camera(withLatitude: -33.86, longitude: 151.20, zoom: 6.0)
        mapView = GMSMapView.map(withFrame: CGRect.zero, camera: camera)
        view.addSubview(mapView)

        mapView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            mapView.topAnchor.constraint(equalTo: view.topAnchor),
            mapView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            mapView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            mapView.bottomAnchor.constraint(equalTo: view.bottomAnchor)
        ])

        super.init()
    }

    private func updateMapCamera() {
        let camera = GMSCameraPosition.camera(withLatitude: latitude, longitude: longitude, zoom: Float(zoom))
        mapView.camera = camera
    }
}
