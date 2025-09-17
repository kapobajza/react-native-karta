//
//  HybridKarta.swift
//  Pods
//
//  Created by Kapobajza on 9/17/2025.
//

import Foundation
import UIKit

class HybridKarta : HybridKartaSpec {
  // UIView
  var view: UIView = UIView()

  // Props
  var isRed: Bool = false {
    didSet {
      view.backgroundColor = isRed ? .red : .black
    }
  }
}
