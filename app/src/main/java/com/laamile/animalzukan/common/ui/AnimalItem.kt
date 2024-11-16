import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.laamile.animalzukan.GetAnimalsQuery
import com.laamile.animalzukan.R

@Composable
fun AnimalItem(animal: GetAnimalsQuery.Animal, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(animal.animalID) }, // インタラクションのフィードバック
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 左側に円形の画像を配置
            Image(
                painter = rememberAsyncImagePainter(
                    model = animal.imageURL,
                    placeholder = painterResource(R.drawable.ic_launcher_background), // プレースホルダー画像
                    error = painterResource(R.drawable.ic_launcher_foreground) // エラー時の画像
                ),
                contentDescription = "${animal.commonName}の画像",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape) // 円形にクリップ
                    .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.width(16.dp)) // 画像とテキストの間にスペース

            // 右側にテキスト情報を配置
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = animal.commonName,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = animal.scientificName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
