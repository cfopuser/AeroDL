package io.github.kdroidfilter.ytdlpgui.features.onboarding.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.composefluent.FluentTheme
import io.github.composefluent.component.Button
import io.github.composefluent.component.Text
import org.jetbrains.compose.resources.stringResource
import ytdlpgui.composeapp.generated.resources.Res
import ytdlpgui.composeapp.generated.resources.next
import ytdlpgui.composeapp.generated.resources.onboarding_previous
import ytdlpgui.composeapp.generated.resources.onboarding_skip

@Composable
internal fun NavigationRow(
    onNext: () -> Unit,
    onPrevious: (() -> Unit)? = null,
    nextLabel: String? = null,
    previousLabel: String? = null,
    nextEnabled: Boolean = true
) {
    val resolvedNext = nextLabel ?: stringResource(Res.string.next)
    val resolvedPrevious = previousLabel ?: stringResource(Res.string.onboarding_previous)
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            if (onPrevious != null) {
                Button(
                    onClick = onPrevious,
                    content = { Text(resolvedPrevious) }
                )
            }
        }
        Row {
            Button(
                onClick = onNext,
                disabled = !nextEnabled,
                content = { Text(resolvedNext) }
            )
        }
    }
}

@Preview
@Composable
private fun NavigationRowFullPreview() {
    FluentTheme {
        Column(Modifier.padding(16.dp)) {
            NavigationRow(
                onNext = {},
                onPrevious = {},
                nextEnabled = true
            )
        }
    }
}

@Preview
@Composable
private fun NavigationRowOnlyNextPreview() {
    FluentTheme {
        Column(Modifier.padding(16.dp)) {
            NavigationRow(
                onNext = {},
                nextEnabled = true
            )
        }
    }
}

@Preview
@Composable
private fun NavigationRowNextDisabledPreview() {
    FluentTheme {
        Column(Modifier.padding(16.dp)) {
            NavigationRow(
                onNext = {},
                onPrevious = {},
                nextEnabled = false
            )
        }
    }
}