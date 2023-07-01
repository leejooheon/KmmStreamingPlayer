import Foundation
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) { }

    func makeUIViewController(context: Context) -> some UIViewController {
        
        MainScreenKt.MainViewController(
            testState: TestState(
                title: "ios title",
                count: 1000
            ),
            onButtonClicked: {
                
            }
        )
    }
}
